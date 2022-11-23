/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;


/**
 * Electronic mail.
 *
 * Probably DSGVO relevant.
 *
 * TODO Hostname exists?
 * TODO email exists check
 */
public final class EMail implements Comparable<EMail>
 {
  /**
   * Local part regexp.
   */
  private static final Pattern LOCAL_REGEXP = Pattern.compile("^[A-Za-z0-9.!#$%&'*+/=?^_`{|}~-]+$"); //$NON-NLS-1$

  /**
   * EMail.
   */
  private final String email;

  /**
   * EMails domain part.
   */
  private final Hostname domainPart;

  /**
   * EMails local part.
   */
  private final String localPart;


  /**
   * Constructor.
   *
   * Comments, double quotes and UTF-8 characters within the emails local part are not yet supported.
   *
   * @param email EMail
   * @throws NullPointerException if email is null
   * @throws IllegalArgumentException if email is not an supported email address
   */
  public EMail(final String email)
   {
    super();
    Objects.requireNonNull(email, "email"); //$NON-NLS-1$
    if ((email.length() < 6) || (email.length() > 254))
     {
      throw new IllegalArgumentException("To short or long for an email address"); //$NON-NLS-1$
     }
    final String[] parts = email.split("@"); //$NON-NLS-1$
    if (parts.length != 2)
     {
      throw new IllegalArgumentException("Not an email address, missing or to much @"); //$NON-NLS-1$
     }
    if (parts[0].length() > 64)
     {
      throw new IllegalArgumentException("Local part greater than 64 characters"); //$NON-NLS-1$
     }
    if (parts[1].charAt(0) == '[')
     {
      parts[1] = (parts[1].toLowerCase(Locale.getDefault()).startsWith("[ipv6:")) ? parts[1].substring(6) : parts[1].substring(1); //$NON-NLS-1$
      if (!parts[1].endsWith("]")) //$NON-NLS-1$
       {
        throw new IllegalArgumentException("Missing end of IPv4/IPv6 address"); //$NON-NLS-1$
       }
      parts[1] = parts[1].substring(0, parts[1].length() - 1);
     }
    this.domainPart = Hostname.of(parts[1]); // Check hostname and store for isReachable
    if ((parts[0].charAt(0) == '(') || (parts[0].charAt(parts[0].length() - 1) == ')'))
     {
      throw new IllegalArgumentException("Comments in email addresses are not supported"); //$NON-NLS-1$
     }
    if (parts[0].indexOf('"') > -1)
     {
      throw new IllegalArgumentException("Double quotes in email addresses are not supported"); //$NON-NLS-1$
     }
    if ((parts[0].charAt(0) == '.') || (parts[0].charAt(parts[0].length() - 1) == '.'))
     {
      throw new IllegalArgumentException("A dot is not allowed at start or end of an emails local part"); //$NON-NLS-1$
     }
    if (parts[0].contains("..")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("Two or more dots behind each other are not allowed within an emails local part"); //$NON-NLS-1$
     }
    if (!EMail.LOCAL_REGEXP.matcher(parts[0]).matches())
     {
      throw new IllegalArgumentException("Illegal character found in emails local part or unsupported UTF-8 character"); //$NON-NLS-1$
     }
    this.localPart = parts[0]; // Store for check receiver
    this.email = email;
   }


  /**
   * EMail factory.
   *
   * @param email EMail
   * @return EMail object
   */
  public static EMail of(final String email)
   {
    return new EMail(email);
   }


  /**
   * Get email string.
   *
   * @return EMail string
   * @deprecated Use stringValue() instead
   */
  @Deprecated
  public String getEMail()
   {
    return this.email;
   }


  /**
   * Returns the value of this EMail as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return this.email;
   }


  /**
   * Get emails domain part string.
   *
   * @return Domain part string
   */
  public String getDomainPart()
   {
    return this.domainPart.stringValue();
   }


  /**
   * Get emails reverse domain part string.
   *
   * @return Reverse domain part string
   */
  public String getReverseDomainPart()
   {
    return this.domainPart.getReverseHostname();
   }


  /**
   * Get emails local part string.
   *
   * @return Local part string
   */
  public String getLocalPart()
   {
    return this.localPart;
   }


  /**
   * Calculate hash code.
   *
   * @return Hash
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
   {
    return this.email.hashCode();
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof EMail))
     {
      return false;
     }
    final EMail other = (EMail)obj;
    return this.email.equals(other.email);
   }


  /**
   * Returns the string representation of this EMail.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "EMail[email=user@example.com]"
   *
   * @return String representation of this EMail
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("EMail[email=").append(this.email).append(']'); //$NON-NLS-1$
    return builder.toString();
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final EMail obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.email.compareTo(obj.email); // TODO hostname, username
   }

 }
