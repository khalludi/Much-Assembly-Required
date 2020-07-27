package net.simon987.mar.server.assembly.instruction;

import net.simon987.mar.server.assembly.CPU;
import net.simon987.mar.server.assembly.Instruction;
import net.simon987.mar.server.assembly.Status;
import net.simon987.mar.server.assembly.Target;

/**
 * Conditional jump: jump if greater or equal
 */
public class JgeInstruction extends Instruction {

    public static final int OPCODE = 16;

    private final CPU cpu;

    public JgeInstruction(CPU cpu) {
        super("jge", OPCODE);

        this.cpu = cpu;
    }

    @Override
    public Status execute(Target src, int srcIndex, Status status) {
        if (status.isSignFlag() == status.isOverflowFlag()) {
            cpu.setIp((char) src.get(srcIndex));
        }
        return status;
    }

    @Override
    public Status execute(int src, Status status) {
        if (status.isSignFlag() == status.isOverflowFlag()) {
            cpu.setIp((char) src);
        }
        return status;
    }
}