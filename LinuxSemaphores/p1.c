#include <stdio.h>
#include "awk_sem.h"

main()
{
    int i = 0;
    // *** Please insert proper semaphore initialization here

    int sem1 = create_sem(".", 'A', 1);
    int sem2 = create_sem(".", 'B', 1);
    int sem3 = create_sem(".", 'C', 0);

    do
    {
        // *** this is where you should place semaphore

        P(sem1); // save itself
        P(sem1); // save itself

        printf("P1111111111 is here\n");
        i++;

        // *** this is where you should place semaphore

    } while (i < 100);
}