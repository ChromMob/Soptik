package me.chrommob.impl;

import me.chrommob.instructions.Instruction;
import me.chrommob.instructions.InstructionType;

public class JumpInstruction implements Instruction {
    enum JumpType {
        FRONT,
        BACK
    }
    enum ComparisonType {
        EQUALS,
        NOTEQUALS,
        SMALLER
    }
    @Override
    public InstructionType getType() {
        return null;
    }

    @Override
    public String byteRepresentation() {
        return null;
    }

    @Override
    public String codeRepresentation() {
        return null;
    }
}
