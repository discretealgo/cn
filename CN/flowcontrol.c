#include<stdio.h>
int main(){
    int w,i,f,frames[50];
    printf("Enter window size : ");
    scanf("%d",&w);
    printf("Enter no of frames");
    scanf("%d",&f);
    printf("Enter frames: ");
    for(int i=0;i<f;i++){
        scanf("%d",&frames[i]);
    }
    printf("with sliding window protocol frames send in following way: ");
    printf("after sending %d frame at each stage sender waits for acknoledgement sent by reciever \n",w);
    for(int i=1;i<=f;i++){
        if(i%w==0){
            printf("frame %d\n",frames[i]);
            printf("acknowledgement of above frame sent recived by sender\n");
        }
        else{
            printf("frame %d\n",frames[i]);
            }
        }
        if(i%w!=0){
            printf("acknowledgement of above fframe recieved by sender\n");
        }
    
    return 0;
}







/*



#include <stdio.h>

int main() {
    int w, i, f, frames[50];
    printf("Enter window size: ");
    scanf("%d", &w);
    printf("Enter number of frames: ");
    scanf("%d", &f);
    printf("Enter frames: ");
    for(i = 0; i < f; i++) {
        scanf("%d", &frames[i]);
    }
    printf("With sliding window protocol, frames are sent in the following way:\n");
    printf("After sending %d frames at each stage, the sender waits for acknowledgement sent by the receiver.\n", w);
    
    for(i = 0; i < f; i++) {
        printf("Frame %d\n", frames[i]);
        if ((i + 1) % w == 0 || i == f - 1) {  // After w frames or the last frame
            printf("Acknowledgement of above frames received by sender\n");
        }
    }
    return 0;
}
*/