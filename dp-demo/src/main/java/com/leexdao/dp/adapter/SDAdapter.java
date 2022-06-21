package com.leexdao.dp.adapter;

/**
 * @description:
 * 场景 一般来说相机上面支持SD卡，而我们自己购买的是TF卡，两个是不兼容的。TF卡无法在SD上面进行使用
 * 这个时候就需要一个适配器，将TF卡插到适配器上，然后用适配器去连接相机的SD卡槽即可
 * 一般来说适配器适配器模式是为了接口的兼容性问题，实现的方式有两种 类适配器(继承实现)和对象适配器(组合实现)
 * @author: leexdao
 * @create: 2022-05-31
 **/
public class SDAdapter {

    static class SD{
        public String readData(){
            return  "SD卡读取数据";
        }
    }

    static class TF extends SD {
       @Override
       public String readData(){
          return  "TF卡使用适配器读取数据";
       }
    }

    static class Camera{
        public void  process(SD sd){
            System.out.println("只支持SD卡" +sd.readData());
        }
    }


    public static void main(String[] args) {
        Camera camera=new Camera();
        camera.process(new SD());
        camera.process(new TF());
    }
}
