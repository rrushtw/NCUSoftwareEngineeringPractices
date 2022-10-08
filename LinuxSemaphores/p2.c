#include <stdio.h>
#include "awk_sem.h"

main()
{
    int i = 0;
    // *** Please insert proper semaphore initialization here

    int sem1 = get_sem(".", 'A');
    int sem2 = get_sem(".", 'B');
    int sem3 = get_sem(".", 'C');

    do
    {
        // *** this is where you should place semaphore

        P(sem2); // save itself
        P(sem2); // save itself

        printf("P222222222 is here\n");
        i++;

        V(sem3); // call back p3
        V(sem3); // call back p3

        // *** this is where you should place semaphore

    } while (i < 100);
}