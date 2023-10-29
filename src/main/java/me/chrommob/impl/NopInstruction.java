package me.chrommob.impl;

import me.chrommob.instructions.Instruction;
import me.chrommob.instructions.InstructionType;

public class NopInstruction implements Instruction {
    public static NopInstruction getDefault() {
        return new NopInstruction();
    }

    @Override
    public InstructionType getType() {
        return InstructionType.NOP;
    }

    @Override
    public String byteRepresentation() {
        return "000000";
    }

    @Override
    public String codeRepresentation() {
        return "nothing";
    }

}
