package coding.questions;

public class FindPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public double myPow(double x, int n) {
		if(n==Integer.MAX_VALUE) return 0.0;
        int k=Math.abs(n);
        int size=k+1;
        double[] p=new double[size];
        if(n==0) return 1;
        if(n==1) return x;
        p[1]=x;
        if(n>0){
            for(int i=2;i<=k;i++){
                p[i] = x*p[i-1];
            } 
        }else{
            for(int i=2;i<=k;i++){
                p[i] = 1/(x*p[i-1]);
            } 
        }
        return p[k];
    }

}
