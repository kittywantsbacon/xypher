# Xypher

## A program for encoding/decoding text with various ciphers

Cryptography is an integral part of modern computing, and has an interesting and extensive history.
This tool automates the use of common *pre-computer* cipher algorithms to allow easy exploration 
of their applications. 

This tool could be used by anyone wishing to play around with or learn about simple ciphers.

Features:
 - Converts to and from common pre-computer ciphers.
 - Command-line interface

This topic is of interest to me because of the role that modern ciphers (encryption) play in
digital security today, and because of the mathematics that are involved.

## Version 1.0.0-alpha features:
- Command line interface
- Atbash Cipher
- Caesar Cipher
- ROT13 Cipher
- Add Ciphers to a sequence
- Encode and decode alphabetic text


## User Stories

### Phase 1:
I want to be able to:
- Select from a list of cipher algorithms.
- Configure settings for each algorithm (if available).
- Use cipher algorithms to convert back and forth from legible text.
- Add cipher algorithms to a sequence to be applied to text sequentially.

### Phase 2:
I want to be able to:
- Save my configuration of ciphers to a file.
- Save my configuration of sequences to a file.
- Quickly load both from a file.

### Phase 3:
I want to be able to:
- Do the above, with a gui
- Hear a nice dopamine-inducing sound when encoding text

## Instructions for Grader
- Run JfxMain
- Choose AtbashCipher from Available encoders
- Click add
- Choose Sequence from Available encoders
- Fill in a fun name
- Click add
- Choose the sequence you just added to CONFIGURE
- Choose AtbashCipher as the active encoder
- (first event)
- Click Add Active Cipher to Sequence!
- (second event)
- Type index 0 and click Remove Cipher from Sequence to remove!
- Select AtbashCipher as the Active Encoder
- type some text into the input
- (Sound event)
- Click encode! and enjoy the nice pleasant sfx while your message is encoded
- (save event)
- Select any Encoder to be active and press save to save it if it isnt already.
- (try Rot13, atbash is already saved)
- (load event)
- Type "TestSequence" into the Name to Load... and click load. check that it is loaded

Notes: Invalid inputs will result in no operations performed. Exceptions are handled by
the javafx library, so the overall application is robust.

## References
 (To be formatted)
 - https://www.tutorialspoint.com/java/java_documentation.htm
 - http://practicalcryptography.com/ciphers/
 - http://rumkin.com/tools/cipher/
 - https://brilliant.org/wiki/enigma-machine/
 - https://wiki.c2.com/
 - https://stackoverflow.com/questions/16458564/convert-character-to-ascii-numeric-value-in-java
 - https://www.ascii-code.com/
 - https://stackoverflow.com/questions/6802483/how-to-directly-initialize-a-hashmap-in-a-literal-way
 - https://www.geeksforgeeks.org/reflection-in-java/
 - https://stackoverflow.com/questions/1098117/can-one-do-a-for-each-loop-in-java-in-reverse-order
 - https://docs.oracle.com/javase/tutorial/reflect/class/classNew.html
 - https://www.geeksforgeeks.org/variable-arguments-varargs-in-java/
 - https://stackoverflow.com/questions/3629596/deserializing-an-abstract-class-in-gson
 
 ## Libraries
 - https://github.com/google/guava/
 - https://github.com/google/gson
 - https://code.google.com/archive/p/cliche/