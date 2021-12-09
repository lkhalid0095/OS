/**
 * Author - Lubna Khalid
 * HW-4
 */
//initial position of disk head
const head = 65;
//max # of cylinders 5000 (0-4999)
const maxCylinders = 4999;
//50 requests provided
const cylinders = [4078, 153, 2819, 3294, 1433, 211, 1594, 2004, 2335, 2007, 771, 1043, 3950,
2784, 1881, 2931, 3599, 1245, 4086, 520, 3901, 2866, 947, 3794, 2353, 3970, 3948, 1815, 4621,
372, 2684, 3088, 827, 3126, 2083, 584, 4420, 1294, 917, 2881, 3659, 2868, 100, 1581, 4581, 1664,
1001, 1213, 3439, 4706, 4869];
//function for first come first serve scheduling
const FCFS = () => {
 let steps = Math.abs(head - cylinders[0]);
 for (let i = 0; i < cylinders.length - 1; i++) {
 steps += Math.abs(cylinders[i] - cylinders[i + 1]);
 }
 console.log(`FCFS cylinders used: ${steps}`)
}
FCFS();
//Shortest Seek Time First Scheduling
const SSTF = () => {
 const arr = cylinders;
 let steps = 0, over = 0, under = 0;
 arr.unshift(head);
 arr.sort(function(a, b) { return a - b });
 let index = arr.indexOf(head);
 while (arr.length > 1) {
 if (index === 0 || index === (arr.length - 1)) {
 if (index === 0) {
 steps += (arr[1] - arr[0]);
 arr.shift();
 } else {
 steps += (arr[arr.length - 1] - arr[arr.length - 2]);
 index--;
 arr.pop();
 }} else {
 over = arr[index + 1] - arr[index];
 under = arr[index] - arr[index - 1];
 if (over >= under) {
 steps += under;
 index--;
 arr.splice(index++, 1);
 } else {
 steps += over;
 index++;
 arr.splice(index--, 1);
 }
 }
 }
 console.log(`SSTF cylinders used: ${steps}`);
}
SSTF();
//SCAN Scheduling
const SCAN = () => {
 let over = Math.max(...cylinders) - head,
 under = head - Math.min(...cylinders);
 if (over >= under) {
 steps = head + Math.max(...cylinders)
 } else {
 steps = (maxCylinders - head) + (maxCylinders - Math.min(...cylinders))
 }
 console.log(`SCAN cylinders used ${steps}`);
}
SCAN();