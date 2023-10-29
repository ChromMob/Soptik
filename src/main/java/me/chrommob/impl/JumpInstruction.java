package me.chrommob.impl;

import me.chrommob.instructions.Instruction;
import me.chrommob.instructions.InstructionType;


public class JumpInstruction implements Instruction {
    private final JumpType jumpType;
    private final ComparisonType comparisonType;

    private String value1;
    private int value1Int;

    private String value2;
    private int value2Int;

    private String jump;
    private int jumpInt;

    public JumpInstruction(int value1, int value2, int jump, JumpType jumpType, ComparisonType comparisonType) {
        this.jumpType = jumpType;
        this.comparisonType = comparisonType;
        if (Instruction.verifyReg(value1) || Instruction.verifyReg(value2)) {
            throw new IllegalArgumentException("Too high value of registry");
        }

        if (jump < 0) {
            jump = Math.abs(jump);
        }

        this.value1 = Instruction.convertToFormattedHex(value1, 4);
        value1Int = value1;

        this.value2 = Instruction.convertToFormattedHex(value2, 4);
        value2Int = value2;

        this.jump = Instruction.convertToFormattedHex(jump, 16);
        jumpInt = jump;
    }

    public enum JumpType {
        FORWARD,
        BACK
    }
    public enum ComparisonType {
        EQUALS,
        NOTEQUALS,
        SMALLER
    }
    @Override
    public InstructionType getType() {
        switch (jumpType) {
            case FORWARD -> {
                switch (comparisonType) {
                    case EQUALS -> {
                        return InstructionType.JUMP;
                    }
                    case NOTEQUALS -> {
                        return InstructionType.NEQJUMP;
                    }
                    case SMALLER -> {
                        return InstructionType.LTJUMP;
                    }
                }
            }
            case BACK -> {
                switch (comparisonType) {
                    case EQUALS -> {
                        return InstructionType.REVJUMP;
                    }
                    case NOTEQUALS -> {
                        return InstructionType.REVNEQJUMP;
                    }
                    case SMALLER -> {
                        return InstructionType.REVLTJUMP;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String byteRepresentation() {
        return value1 + value2 + jump;
    }

    @Override
    public String codeRepresentation() {
        String comparator = switch (comparisonType) {
            case EQUALS -> "==";
            case NOTEQUALS -> "!=";
            case SMALLER -> "<";
        };
        String comparator2 = jumpType == JumpType.FORWARD ? "+" : "-";
        return "if (reg" + value1Int + " " +
                comparator + " reg" + value2Int + " pc " + comparator2 + "= imm";
    }
}
