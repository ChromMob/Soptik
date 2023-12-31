package me.chrommob;

import me.chrommob.instructions.Instruction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File output = new File("output.sopt");
        File byteOutput = new File("ouputByte.sopt");
        Transpiler tp = new Transpiler();

        tp.setValueOfReg(1, 0, 50);
        tp.storeFromRegToMem(0, 1, 100);

        if (tp.getInstructionList().size() > 256)
            throw new IllegalArgumentException("TOO MUCH");

        if (byteOutput.exists()) {
            byteOutput.delete();
        } else {
            try {
                byteOutput.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (output.exists()) {
            output.delete();
        } else {
            try {
                output.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter writer = new FileWriter(output);
            FileWriter byteWriter = new FileWriter(byteOutput);
            for (Instruction ins : tp.getInstructionList()) {
                String write = ins.getType().getId() + ins.byteRepresentation();
                byteWriter.write(write + "\n");
                writer.write(ins.codeRepresentation() + "\n");
            }
            
            writer.close();
            byteWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

