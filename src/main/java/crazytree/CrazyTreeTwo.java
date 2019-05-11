package crazytree;

import java.io.*;


    class CrazyTreeTwo {
        public static void main(String args[] ) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            String l[]=line.split(" ");
            int mod=1299709;
            int L = Integer.parseInt(l[0]);
            int Q = Integer.parseInt(l[1]);
            int ar[]=new int[((1<<L)-1)];
            try{
                if(L>1)
                {
                    for(int i=L-1;i>0;i--)
                    {
                        int lim=1<<(i);
                        int start=lim-1;
                        int start2=(1<<i+1)-1;
                        //System.out.println(lim+" start"+start+" start2"+start2);
                        for(int j=0;j<lim;j++)
                        {
                            if(i==L-1)
                            {
                                ar[start+j]=(j%mod+1)%mod;
                                //System.out.println(j+" "+ar[start+j]);
                            }
                            else
                            {
                                ar[start+j]=(int)(((long)ar[start2+2*j]*(long)ar[start2+2*j+1])%mod);
                                //System.out.println(j+" "+ar[start+j]);
                            }
                        }
                    }
                    ar[0]=(int)(((long)ar[1]*(long)ar[2])%mod);
                    //int numb=(int)((long)ar[1]*(long)ar[2])%mod;
                    //System.out.println(numb);
                    for(int i=L-1;i>0;i--)
                    {
                        int lim=1<<(i);
                        int start=lim-1;
                        int start2=(1<<i+1)-1;
                        for(int j=1;j<lim;j++)
                        {
                            ar[start+j]=(int)((long)ar[start+j]+(long)ar[start+j-1]%mod);
                        }
                    }
                    //for(int i=0;i<ar.length;i++)
                    //System.out.printf("%d ",ar[i]);
                    for (int i = 0; i < Q; i++)
                    {
                        int ans=0;
                        line = br.readLine();
                        String l1[]=line.split(" ");
                        int N=Integer.parseInt(l1[0])-1;
                        int X=Integer.parseInt(l1[1])-1;
                        int Y=Integer.parseInt(l1[2])-1;
                        if(N==0)
                            ans=ar[0];
                        else if(N==1)
                        {
                            if(X==0)
                                ans=ar[Y+1]%mod;
                            else
                                ans=(ar[2]-ar[1])%mod;
                        }
                        else{


                            int X1=((1<<(N))-1+X);//>0?((1<<(N-1))+X-1):0;
                            int Y1=((1<<(N))-1+Y);//>0?(1<<(N-1)+X-1):0;
                            if(X==0)
                                //System.out.println(X+" Y "+Y);
                                ans=ar[Y1]%mod;
                            else
                            {
                                //System.out.println(X1+" Y "+Y1);
                                ans=(ar[Y1]-ar[X1-1])%mod;
                            }
                        }
                        if(ans<0)
                            ans+=mod;
                        System.out.println(ans);
                    }
                }
                else
                {
                    for (int i = 0; i < Q; i++)
                    {
                        line = br.readLine();
                        String l1[]=line.split(" ");
                        int N=Integer.parseInt(l1[0])-1;
                        int X=Integer.parseInt(l1[1])-1;
                        int Y=Integer.parseInt(l1[2])-1;
                        System.out.println(1);
                    }
                }

            }
            catch(Exception e)
            {
                System.out.println(e);
            }

            //System.out.println(M);
        }
    }
