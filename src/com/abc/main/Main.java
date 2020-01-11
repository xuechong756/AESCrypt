package com.hzy.main;

import com.hzy.aes.AESCrypt;

public class Main {
	
	public static void main(String[] arguments) {
		
		String words = "FxienEtbi#xe$A";
		//String words = "NLK+IPcQEPmTWq75hn3iVU6ifmi7ecTyQCy6bBi5nnkJ4ehdit1wJPlUfQa1IA/5FWOILvIk3Xz3no+2cxvZqPPvOMm5VYxg5+flYOOdGbi/rJMF4Qx5PFdsfEofUUW3n/lht2dYzu6CXp5QQtWAaABs4Xcn6jFSQny0t/3ROuoOq9Bg3GGynOoFB18ZtumK3UmTRdOMe/raLUecHlb6pErt3FEww0jICymh5znk7x5weg3FkBimimo7D+IXQB2FWpDANTRFYFK/SNcYz1+bZO734mOkyqpvQgw9HMklkXGr1yBwvX9LEetY6NNNe3r99w16CTCT6TWUI+2TtQtfgtuTVyJqnfkEJa8IWUfLTcOllTsWp/TM+VEEd8yhmqYUlrYU2K4v/6tAmslTkkns8acYRgXlgST3s2NiqAEkc9m7HmnBy3z0gA0Zt4Qb4765sLklbVbmVKSMKqQIi8XAZw0MefGHcVDTbIQ31mypw9S150HPL5uAzti+cJIV7JDwEV+UAkgXx4sqg1oQwKfsFd5N0z9YAyz7ViTlpysCQGBbju1wb1tcA13QCQRnY8KgxFdlxxDGOD0pSYZaOZ+t+7qeX+khZbuzuH+c4lCK9s0=";
		String encrypt = AESCrypt.encrypt(words);//加密
		String decrypt = AESCrypt.decrypt(words);//解密
		System.out.println("加密：" + encrypt);
		System.out.println("解密：" + decrypt);
		
	}
}
