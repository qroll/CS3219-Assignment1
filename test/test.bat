@ECHO OFF

SET totalTests=4

FOR /L %%A IN (1,1,%totalTests%) DO (
  java -cp ../bin KWIC < input%%A.txt > output%%A.txt
  fc expected%%A.txt output%%A.txt
)
