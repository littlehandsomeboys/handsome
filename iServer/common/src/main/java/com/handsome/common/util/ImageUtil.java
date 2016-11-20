package com.handsome.common.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

public class ImageUtil
{
	
	/**
	 * 
	 * @param imagePath 原图地址
	 * @param px 目标切片坐标 x轴起点
	 * @param py 目标切片坐标 y轴起点
	 * @param pw 目标切片 宽度
	 * @param ph 目标切片 高度
	 * @param boundx 切源片宽
	 * @param boundy 切源片长
	 * @return
	 */
	public static String cutImage(String imagePath, int px, int py, int pw, int ph, int boundx, int boundy)
	{
		Image img;
		ImageFilter cropFilter;
		String url = "";
		try
		{
			// 读取源图像
			File srcpic = new File(imagePath);
			BufferedImage bi = ImageIO.read(srcpic);
			int srcWidth = bi.getWidth();// 原图宽度
			int srcHeight = bi.getHeight();// 原图高度
			
			//比例
			float proportion = (float)srcWidth/(float)boundx;
			int x = (int) (px * proportion);
			int y = (int) (py * proportion);
			int w = (int) (pw * proportion);
			int h = (int) (ph * proportion);
			
			
			
			// 若原图大小大于大于切片大小，则进行切割
			if (srcWidth >= w && srcHeight >= h)
			{
				Image image = bi.getScaledInstance(srcWidth, srcHeight,
						Image.SCALE_DEFAULT);
				// int x1=x*srcWidth/400;
				// int y1=y*srcHeight/270;
				// int w1=w*srcWidth/400;
				// int h1=h*srcHeight/270;
				int x1 = x;
				int y1 = y;
				int w1 = w;
				int h1 = h;

				cropFilter = new CropImageFilter(x1, y1, w1, h1);
				img = Toolkit.getDefaultToolkit().createImage(
						new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage tag = new BufferedImage(w1, h1,
						BufferedImage.TYPE_INT_BGR);
				Graphics g = tag.getGraphics();
				g.drawImage(img, 0, 0, null);
				g.dispose();

				url = imagePath.substring(0,
						imagePath.lastIndexOf("/") + 1);
				String name = imagePath
						.substring(imagePath.lastIndexOf("/") + 1);
//				System.out.println(name);
				String[] src = name.split("\\.");
				Date now = new Date();
				imagePath = src[0].concat(String.valueOf(now.getTime())).concat("_cut.").concat(src[1]);
				url = url.concat(imagePath);
//				System.out.println(imagePath);
//				String[] src = imagePath.split("\\.");
				//删除老图
//				srcpic.delete();
				//创建新图
				ImageIO.write(tag, src[1], new File(url));
				
			}

		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String [] s = {imagePath, url};
		return imagePath;
	}
	
	public static void main(String[] args)
	{
		
		String imagePath = "/share/doc/head/20161113232721_default.png";
		
		String newPath = cutImage(imagePath,  50,  50,  100,  100,  249,  253);
		System.out.println(newPath);
//		System.out.println(newPath[1]);
	}
}
