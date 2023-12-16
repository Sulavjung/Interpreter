[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/tOu9l-Id)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13240242)
# Assignment 4 (Interpreter) Documentation

Author: Sulav Jung Hamal

## Scope of Work

Mark each of the requirements you completed by adding an X in between the square brackets. If you have any comments for a given section, add them in the "Comments from student" section (i.e. I almost finished this, but 3 tests aren't passing).

| Requirement                           | Completed? | Comments from student |
| ------------------------------------- | ---------- | --------------------- |
| 1. Standard byte codes implemented    | [X]         |     It was hard to implement each class and to have correct methods and fields within those classes.                   |
| 2. CodeTable implemented              | [X]         |        It was fairly simple and straightforward.               |
| 3. ByteCodeLoader implemented         | [X]         |          This was tricky. Especially the reflection part. Still, it doesn't make sense that much syntax-wise but it did work after a lot of YouTube videos.              |
| 4. Program implemented                | [X]         |       The part where we resolved special addresses was tricky. Had to scratch my head for a few days on that.                 |
| 5. RuntimeStack implemented           | [X]         |         It was fairly simple initially. But I had to fix it multiple times over many days while writing the Byte Code extended classes.              |
| 6. New bytecode implemented (DMP)     | [X]         |        It was simple. I did this part at last. So, I had a pretty good sense of how the logic was being handled over different files.               |
| 7. Output correct (for byte codes)    | [X]         |        Some of the output requirements were tricky. Like the one in the call and return. I tried to take care of different types of returns and calls which took more time than I had thought initially.              |
| 8. Output correct (for runtime stack) | [X]         |      I tried with multiple different programs and the provided test itself. It was working fine with them. So, I think it is correct as far as my understanding goes.                   |

## Results and Conclusions

### What I Learned

This assignment was very helpful in learning and getting used to the big code base. I was comfortable with the logic being handled in different files. A few concepts that I learned were: 
1. Reflection: I wasn't known to reflection before. So, it was nice to get to know and implement it. But, I'm not that comfortable with it still. 
2. Inner workings of Interpreter: In the interpreter, we use `ByteCodeLoader` class for reading bytecode instructions from a file and creating instances of corresponding bytecode classes using reflection. Those list of bytecode classes then are passed to the `Program` class. The `VirtualMachine` class manages the execution of these instructions. During execution, each bytecode class is responsible for defining its behavior through the `execute` method. The architecture also facilitates the interpretation of bytecode instructions, maintaining runtime components such as the stack and program counter.

### Challenges I Encountered

Everything felt like a challenge if I'm being honest. But, I appreciate those challenges as I got to learn a lot with this assignment. I have a better understanding of the architecture of the Interpreter and how all the small components act together to do complex tasks. Or, how complex the code gets for something that seemed simple initially.
