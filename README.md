# CSC 369 Hadoop

Each of the 6 tasks can be called by for the Nth task using ./gradlew run --args="AccessLogN input_access_log/ out_wc/"

for example, 3. Total bytes sent to the client with a specified hostname or IPv4 address (you may hard code an address)
would be ./gradlew run --args="AccessLog3 input_access_log/ out_wc/"

Task 1 uses the URL as the key and 1 as the value in map. It then sums accross all of the 1's for each key and then passes to
be sorted described below

Task 2 uses the HTTP code as the key and 1 as the value in map. It then sums accross all of the 1's for each key

Task 3 uses IPv4 address as the key and the number of bytes as the value in map. It then sums accross all of the bytes for 
each key and then passes to be sorted described below

Task 4 uses the IPv4 address as the key but only if that record's URL matches a given URL and 1 as the value in map. It then
sums accross all of the 1's for each key and then passes to be sorted described below

Task 5 uses the month and year as the key and 1 as the value in map. It then sums accross all of the 1's for each key

Task 6 uses the day, month, and year as the key and the number of bytes sent as the value in map. It then sums accross all of
the bytes for each key and passes it to be sorted described below

tasks 2, 3, and 5 only use 1 map reduce phase. Tasks 1, 4, and 6 are supposed to be sorted by the values instead of the keys
so they all use the same 2nd map reduce phase. The 2nd map phase switchs the key and value so that they are sorted by value. It
then switches them back in the reduce phase
