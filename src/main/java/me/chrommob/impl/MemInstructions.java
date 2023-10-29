package me.chrommob.impl;

import me.chrommob.instructions.Instruction;
import me.chrommob.instructions.InstructionType;

public class MemInstructions implements Instruction {
    private final InstructionType type;

    private final String regSave;
    private final int regSaveInt;

    private final String regLoad;
    private final int regLoadInt;

    private final String regPlus;
    private final int regPlusInt;
    public MemInstructions(int regSave, int regLoad, int regPlus, InstructionType type) {
        this.type = type;

        if (Instruction.verifyReg(regSave) || Instruction.verifyReg(regLoad)) {
            throw new IllegalArgumentException("Too high value for reg");
        }

        this.regSave = Instruction.convertToFormattedHex(regSave, 4);
        regSaveInt = regSave;

        this.regLoad = Instruction.convertToFormattedHex(regLoad, 4);
        regLoadInt = regLoad;

        this.regPlus = Instruction.convertToFormattedHex(regPlus, 16);
        regPlusInt = regPlus;
    }
    @Override
    public InstructionType getType() {
        return type;
    }

    @Override
    public String byteRepresentation() {
        return regSave + regLoad + regPlus;
    }

    @Override
    public String codeRepresentation() {
        if (type == InstructionType.LOAD)
            return "reg" + regSaveInt + " = mem[reg" + regLoadInt + " + " + regPlusInt + "]";
        return "mem[reg" + regLoadInt + " + " + regPlusInt + " = reg" + regSave;
    }
}
