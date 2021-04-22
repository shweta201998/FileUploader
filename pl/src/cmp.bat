javac -classpath ..\..\bl\dist\*;. -d ..\classes com\thinking\machines\library\pl\*.java
cd..
cd classes
jar -cvf ..\dist\LibsysPL.jar com