The Syntax error is not having the field name of an entry in a JsonList enclosed in brackets
as is shown on line 4 of payload.json.

In Jackson version 2.2.3, the exception thrown accurately tells which line the syntax error is on
In Jackson version 2.9.8, the exception's location is behind one line of the actual location.

This is shown in response-Jackson-223.json and response-Jackson-298.json
where the line numbers are 4 and 3 respectively.
