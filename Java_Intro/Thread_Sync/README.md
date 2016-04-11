This project is about how to use semaphores to synchronize multiple threads.

PrintDigit will be responsible for repeatedly printing out one digit based on the input parameter, 
PrintLetter for printing letter, and PrintSlashes for printing '/' and '\'. Your job is to add semaphores 
such that the program will repeatedly print out a '/' followed by three digits, then a '\' followed by two letters. 
The following is a correct example: /156\BA/376\YZ/654\JK/257\HG/445\DD……. (Note the end of line was removed to save space.) 
You can add nothing but semaphore-related statements, i.e.,  declaring semaphores and calling acquire or release function 
on semaphores.
