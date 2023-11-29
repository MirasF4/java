@echo off

robocopy \\SOL\webapps\kochbuch\images\data d:\tmpimages /MIR

robocopy D:\projects\java\hbedv\kochbuch \\SOL\webapps\kochbuch /MIR

rem rd \\SOL\webapps\kochbuch\WEB-INF\src  /S/Q

robocopy d:\tmpimages \\SOL\webapps\kochbuch\images\data /MIR

robocopy D:\projects\java\hbedv\upload \\SOL\webapps\upload /MIR

pause