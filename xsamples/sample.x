GOTO start<<1>>
DMP -
LABEL Read
READ
RETURN
LABEL Write
LOAD 0 dummyFormal
WRITE
RETURN
LABEL start<<1>>
LIT 0 j
LIT 0 i
GOTO continue<<3>>
LABEL factorial<<2>>
LOAD 0 n
LIT 2
BOP <
FALSEBRANCH else<<4>>
LIT 1
RETURN factorial<<2>>
POP 0
GOTO continue<<5>>
LABEL else<<4>>
LOAD 0 n
LOAD 0 n
LIT 1
BOP -
ARGS 1
CALL factorial<<2>>
BOP *
RETURN factorial<<2>>
POP 0
LABEL continue<<5>>
POP 0
LIT 0    GRATIS-RETURN-VALUE
RETURN factorial<<2>>
LABEL continue<<3>>
LABEL while<<7>>
LIT 1
LIT 1
BOP ==
FALSEBRANCH continue<<6>>
ARGS 0
CALL Read
ARGS 1
CALL factorial<<2>>
ARGS 1
CALL Write
STORE 1 i
POP 0
GOTO while<<7>>
LABEL continue<<6>>
POP 2
HALT