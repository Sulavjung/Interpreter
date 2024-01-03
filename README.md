# Interpreter Project Documentation

## Author
Sulav Jung Hamal

## Overview

This repository represents my work on the Interpreter project. At its core, the project revolves around the creation of an interpreter that interprets bytecode instructions. The critical components include the `ByteCodeLoader` class, responsible for reading bytecode instructions from a file and dynamically creating instances of corresponding bytecode classes through the use of reflection.

Once instantiated, this list of bytecode classes is then passed to the `Program` class, which acts as the orchestrator for the execution of these bytecode instructions. The heart of the execution process lies in the `VirtualMachine` class, which diligently manages the step-by-step execution of bytecode instructions.

What sets this project apart is the architectural emphasis on the interpretation of bytecode instructions, ensuring the seamless interaction between various components. During the execution phase, each bytecode class assumes a pivotal role, defining its specific behavior through the implementation of the `execute` method.

Moreover, the project's architecture extends beyond mere execution. It actively maintains critical runtime components, including a dynamic stack and program counter, further solidifying its robust interpretative capabilities. Exploring this repository provides a deeper insight into the intricacies of interpreter design, the symbiotic relationship between classes, and the elegance in handling bytecode instructions.


## Completed Tasks

- **Standard Byte Codes Implemented**
  - Successfully implemented various byte codes with careful consideration of methods and fields within each class.

- **CodeTable Implementation**
  - Implemented the CodeTable, providing a straightforward solution.

- **ByteCodeLoader Implementation**
  - Developed the ByteCodeLoader, facing challenges with the reflection part and overcoming them with insights from various online resources.

- **Program Implementation**
  - Successfully implemented the Program, with a focus on resolving special addresses and addressing trickier aspects.

- **RuntimeStack Implementation**
  - Implemented the RuntimeStack, initially facing challenges that required multiple fixes during the development of Byte Code extended classes.

- **New Bytecode (DMP) Implementation**
  - Introduced a new bytecode (DMP) towards the end of the project, leveraging a good understanding of the logic across different files.

- **Correct Output (for Byte Codes)**
  - Ensured correct output for byte codes, addressing some tricky requirements, such as those related to calls and returns.

- **Correct Output (for Runtime Stack)**
  - Validated the correctness of the output for the runtime stack, testing it with various programs, including the provided test.

## Results and Conclusions

### What I Learned

This project significantly contributed to my understanding and familiarity with a large codebase. Key concepts learned include:

1. **Reflection:**
   - Implemented reflection for the first time, gaining valuable insights into its functionality.

2. **Inner Workings of Interpreter:**
   - Explored the intricacies of the interpreter, understanding the role of classes like `ByteCodeLoader`, `Program`, and `VirtualMachine`. Learned how these components collaborate to execute bytecode instructions.

### Challenges Faced

The project presented various challenges, serving as valuable learning opportunities. Notable difficulties included:

- **Complexity:**
  - Found that seemingly simple tasks could lead to complex code, reinforcing the importance of a structured and modular approach.

- **Special Addresses Resolution:**
  - The resolution of special addresses in the Program implementation posed a challenging problem that required considerable effort and contemplation.

## Concluding Thoughts

This project enhanced my programming skills, especially in dealing with larger codebases and implementing intricate functionalities. I now have a deeper understanding of the inner workings of interpreters and have expanded my skill set with the use of reflection.

Feel free to explore the code and commit history to gain insights into the development process and the evolution of the project.
