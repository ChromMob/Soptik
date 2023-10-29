package me.chrommob.instructions;

public interface Instruction {
    InstructionType getType();
    String byteRepresentation();

    String codeRepresentation();

    static boolean verifyReg(int i) {
        return i >= 6;
    }

    static String convertToFormattedHex(int decimal, int bitSize) {
        String hexadecimal = Integer.toHexString(decimal).toUpperCase();
        StringBuilder formattedHex = new StringBuilder();

        int hexLength = hexadecimal.length();
        int zeroCount = bitSize/4 - hexLength;
        if (hexLength + zeroCount > bitSize/4)
            throw new IllegalArgumentException();

        formattedHex.append("0".repeat(Math.max(0, zeroCount)));
        formattedHex.append(hexadecimal);
        return formattedHex.toString();
    }


}
