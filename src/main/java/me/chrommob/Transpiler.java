package me.chrommob;

import me.chrommob.impl.AritmhInsructions;
import me.chrommob.impl.BombInstruction;
import me.chrommob.impl.MemInstructions;
import me.chrommob.impl.NopInstruction;
import me.chrommob.instructions.Instruction;
import me.chrommob.instructions.InstructionType;

import java.util.ArrayList;
import java.util.List;

class Transpiler {
    private final List<Instruction> instructionList = new ArrayList<>();

    private void addIns(Instruction ins) {
        instructionList.add(ins);
    }

    public void addNop() {
        addIns(NopInstruction.getDefault());
    }

    public void addAdd(int toAdd, int add, int save) {
        addIns(new AritmhInsructions(toAdd, add, save, InstructionType.ADD));
    }

    public void addSub(int toSub, int sub, int save) {
        addIns(new AritmhInsructions(toSub, sub, save, InstructionType.SUB));
    }

    public void addMultiply(int toMultiply, int multiplier, int save) {
        addIns(new AritmhInsructions(toMultiply, multiplier, save, InstructionType.MUL));
    }

    public void setValueOfReg(int storeReg, int loadReg, int addition) {
        addIns(new AritmhInsructions(storeReg, addition, loadReg, InstructionType.MOV));
    }

    public void storeFromMemToReg(int regSave, int regLoad, int regPlus) {
        addIns(new MemInstructions(regSave, regLoad, regPlus, InstructionType.LOAD));
    }

    public void storeFromRegToMem(int regToSave, int regToAddTo, int regPlus) {
        addIns(new MemInstructions(regToSave, regToAddTo, regPlus, InstructionType.STORE));
    }

    public void addBomb(int delay) {
        addIns(new BombInstruction(delay));
    }

    public List<Instruction> getInstructionList() {
        return instructionList;
    }
}
