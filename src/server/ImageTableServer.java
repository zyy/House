package server;

import java.util.List;

import entity.ImageTable;

public interface ImageTableServer {

	public boolean add(ImageTable image);//为房源添加图片
	
	public List<ImageTable> selImage(int rid);//根据出租房源id获得图片集合
	
	public boolean deleteImage(int id);
	
	public ImageTable loadImage(int id);
}
