package org.sid.sec;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="med@youssfi.net";
    public static final long EXPIRATION=864000000;
    public static final String HEADER_PREFIX="Bearer ";
}
