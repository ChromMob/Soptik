package me.chrommob.impl;

import me.chrommob.instructions.Instruction;
import me.chrommob.instructions.InstructionType;

public class SetInstruction implements Instruction {
    private final InstructionType it;

    private final String reg;
    private final int regInt;

    private final String value;
    private final int valueInt;

    private final String random = Instruction.convertToFormattedHex(1, 4);

    public SetInstruction(int reg, int value, InstructionType it) {
        this.it = it;

        if (Instruction.verifyReg(reg))
            throw new IllegalArgumentException("Too high value for reg");

        this.reg = Instruction.convertToFormattedHex(reg, 4);
        regInt = reg;

        this.value = Instruction.convertToFormattedHex(reg, 16);
        valueInt = value;
    }

    @Override
    public InstructionType getType() {
        return it;
    }

    @Override
    public String byteRepresentation() {
        return reg + random + value;
    }

    @Override
    public String codeRepresentation() {
        return "reg" + regInt + "[" + (it == InstructionType.SETIMMLOW ? "low" : "high") + "] = " + valueInt;
    }
}
