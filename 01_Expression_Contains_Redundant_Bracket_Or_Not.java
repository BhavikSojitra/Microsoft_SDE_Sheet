class Solution {
   public static int checkRedundancy(String s) {
       Stack<Integer> st=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else if(s.charAt(i)=='*' || s.charAt(i)=='+' || s.charAt(i)=='/' || s.charAt(i)=='-'){
               if((st.size()>0 && st2.size()>0 && st.peek()>st2.peek()) || st.size()==0 || st2.size()==0){
                st2.push(i);}
            }
            else if(s.charAt(i)==')'){
                if(st2.size()==0){
                    return 1;
                }
                else{
                   int p= st2.pop();
                   int q= st.pop();
                   if(p<q){
                       return 1;
                   }
                }
            }
            i++;
        }
        return 0;
   }
}
