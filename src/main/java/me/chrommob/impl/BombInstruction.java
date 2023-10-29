package me.chrommob.impl;

import me.chrommob.instructions.Instruction;
import me.chrommob.instructions.InstructionType;

public class BombInstruction implements Instruction {
    private final String random = Instruction.convertToFormattedHex(0, 8);
    private final String initValue;
    private final int initValueInt;
    public BombInstruction(int initialValue) {
        initValue = Instruction.convertToFormattedHex(initialValue, 16);
        initValueInt = initialValue;
    }
    @Override
    public InstructionType getType() {
        return InstructionType.BOMB;
    }

    @Override
    public String byteRepresentation() {
        return initValue + random;
    }

    @Override
    public String codeRepresentation() {
        return "BOMB " + initValueInt;
    }
}
