package com.construction.util;


import java.nio.ByteBuffer;
import java.util.UUID;

public class UuidUtil {
    public static UUID fromBytes(byte [] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(16).wrap(bytes);
        long hi = buffer.getLong();
        long lo = buffer.getLong();
        return new UUID(hi, lo);
    }

    public static byte [] toBytes(UUID uuid) {
        long hi = uuid.getMostSignificantBits();
        long lo = uuid.getLeastSignificantBits();
        return ByteBuffer.allocate(16).putLong(hi).putLong(lo).array();
    }
}
