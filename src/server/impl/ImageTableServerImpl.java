package server.impl;

import java.util.ArrayList;
import java.util.List;

import server.ImageTableServer;
import server.LeaseRoomServer;
import dao.ProjectDao;
import dao.impl.ProjectDaoimpl;
import entity.ImageTable;
import entity.LeaseRoom;

public class ImageTableServerImpl implements ImageTableServer {

	private ProjectDao dao=new ProjectDaoimpl();
	public boolean add(ImageTable image) {
		// TODO Auto-generated method stub
		return dao.add(image);
	}
	public List<ImageTable> selImage(int rid) {
		// TODO Auto-generated method stub
		String hql="select img from ImageTable img where 1=1 ";
		List args=new ArrayList();
		if(rid!=0){
			hql+=" and img.leaseRoom.id=?";
			args.add(rid);
		}
		 
		List<ImageTable> img=dao.select(hql, args);
		return img;
	}
	public boolean deleteImage(int id) {
		// TODO Auto-generated method stub
		ImageTable image=loadImage(id);
		boolean flag=dao.delete(image);
		List<ImageTable> list=selImage(id);
		LeaseRoomServer server=new LeaseRoomServerImpl(); 
		LeaseRoom room=server.getRoom(image.getLeaseRoom().getId());
		//判断该房源的图片是否被全部删除
		if(list!=null&&list.size()>0){   
			boolean is=true;
			for (int i = 0; i < list.size(); i++) {
				if(room.getImg().equals(list.get(i).getImage())){
					is=false;
					break;
				}
			}
			if(is){
				room.setImg(list.get(0).getImage()); //重设该房源封面
				server.update(room);
			}
		}else{  //图片被全部删除，设置该房源为没有封面
			room.setImg("");
			server.update(room);
		}
		return flag;
	}
	public ImageTable loadImage(int id) {
		// TODO Auto-generated method stub
		return (ImageTable)dao.getPojo(ImageTable.class, id);
	}

}
