# CSC 369 Hadoop

Each of the 6 tasks can be called by for the Nth task using ./gradlew run --args="AccessLogN input_access_log/ out_wc/"

for example, 3. Total bytes sent to the client with a specified hostname or IPv4 address (you may hard code an address)
would be ./gradlew run --args="AccessLog3 input_access_log/ out_wc/"

tasks 2, 3, and 5 only use 1 map reduce phase. Tasks 1, 4, and 6 are supposed to be sorted by the values instead of the keys
so they all use the same 2nd map reduce phase.
