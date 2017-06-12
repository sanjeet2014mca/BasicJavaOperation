/*package com.testng;
package com.testng;

import org.hyperledger.fabric.sdk.Member;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.krypc.api.hl.persist.entities.DeployedChainCodeEntity;
import com.krypc.api.hl.persist.entities.UserEntity;
import com.krypc.api.hlindexer.persist.processor.BenchHLs.ErrorConstants.ERROR_CODES;
import com.krypc.api.responsewrappers.ResponseWrapper;
import com.krypc.hl.wb.bslayerapis.SecureManagerAPIs;
import com.krypc.hl.wb.protoapis.HyperledgerStaticProperty;


public class Testing {
	private static String path_indexed_db= null;
	
	@BeforeTest
	public void setup(){
		path_indexed_db = HyperledgerStaticProperty.path_indexed_db;
		HyperledgerStaticProperty.path_indexed_db=null;
	}
	@AfterTest
	public void onComplete(){
		HyperledgerStaticProperty.path_indexed_db = path_indexed_db;
	}
	@Test(priority=1)
	public void balogin() {
		System.out.println("benchadmin balogin 1");
		Member queringMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("ba@ba.com").getMember();
		DeployedChainCodeEntity currentDeployment=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getCurrentDeployed();
		ResponseWrapper result = SecureManagerAPIs.performLoginAsChainCodeAdmin(queringMember, currentDeployment);
//		System.out.println(result.toJSONString());
		Assert.assertEquals(result.errorCode,0L);
	}
	@Test(priority=2)
	public void addProg() {
		System.out.println("benchadmin addProg 2");
		Member queringMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("ba@ba.com").getMember();
		Member proposedProgramAdminMember = com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("pa@pa.com").getMember();
		DeployedChainCodeEntity currentDeployment=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getCurrentDeployed();
		ResponseWrapper result = SecureManagerAPIs.addProgram(queringMember, "PGM", "PGM", new JSONObject(), proposedProgramAdminMember , currentDeployment);
//		System.out.println(result.toJSONString());
		Assert.assertEquals(result.errorCode,0L);
	}
	@Test(priority=3)
	public void existProg() {
		System.out.println("benchadmin existProg 3");
		Member queringMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("ba@ba.com").getMember();
		Member proposedProgramAdminMember = com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("pa@pa.com").getMember();
		DeployedChainCodeEntity currentDeployment=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getCurrentDeployed();
		ResponseWrapper result = SecureManagerAPIs.addProgram(queringMember, "PGM", "PGM", new JSONObject(), proposedProgramAdminMember , currentDeployment);
//		System.out.println(result.toJSONString());
		Assert.assertEquals(result.errorCode,ERROR_CODES.PRG_ALREADY_EXISTS.getErrorCode());
	}
	@Test(priority=4)
	public void listProg() {
		System.out.println("benchadmin listProg 4");
		Member queringMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("ba@ba.com").getMember();
		DeployedChainCodeEntity currentDeployment=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getCurrentDeployed();
		ResponseWrapper result = SecureManagerAPIs.listPrograms(queringMember, currentDeployment);
//		System.out.println(result.toJSONString());
		Assert.assertEquals(result.errorCode,0L);
	}
	@Test(priority=5)
	public void palogin() {
		System.out.println("programadmin palogin 1");
		Member queringMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("pa@pa.com").getMember();
		DeployedChainCodeEntity currentDeployment=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getCurrentDeployed();
		ResponseWrapper result = SecureManagerAPIs.performLoginAsProgramAdmin(queringMember, "PGM", currentDeployment);
//		System.out.println(result.toJSONString());
		Assert.assertEquals(result.errorCode,0L);
	}
	@Test(priority=6)
	public void  wrongUser() {
		System.out.println("programadmin wrongUser 2");
		System.out.println("user unavailable");
		UserEntity queringMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("pa2@pa.com");
		Assert.assertEquals(String.valueOf(queringMember),"null");
	}
	@Test(priority=7)
	public void sameEntity(){
		System.out.println("programadmin sameEntity 3");
		System.out.println("sameEntity");
		Member invokingMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("pa@pa.com").getMember();
		DeployedChainCodeEntity currentDeployment=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getCurrentDeployed();
		ResponseWrapper result = SecureManagerAPIs.addEntity(invokingMember, "PGM", "sano", "V3X0SPYIY6", new JSONObject(), currentDeployment);
		Assert.assertEquals(result.errorCode,ERROR_CODES.ENTITY_ALREADY_EXISTS.getErrorCode());

	}
	@Test(priority=8)
	public void addEntity(){
		System.out.println("programadmin addEntity 4");
		System.out.println("addEntity");
		Member invokingMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("pa@pa.com").getMember();
		DeployedChainCodeEntity currentDeployment=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getCurrentDeployed();
		ResponseWrapper result = SecureManagerAPIs.addEntity(invokingMember, "PGM", "t", "ab", new JSONObject(), currentDeployment);
		Assert.assertEquals(result.errorCode,0L);
	}
	@Test(priority=9)
	public void addActor(){
		System.out.println("programadmin addActor 5");
		System.out.println("addActor");
		Member invokingMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("pa@pa.com").getMember();
		DeployedChainCodeEntity currentDeployment=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getCurrentDeployed();
		ResponseWrapper result = SecureManagerAPIs.addActor(invokingMember, "PGM", "sano", "sanji", "sanji",  new JSONObject(), currentDeployment);
		Assert.assertEquals(result.errorCode,0L);
	}
	@Test(groups= "programadmin",priority=10)
	public void sameActor(){
		System.out.println("programadmin sameActor 6");
		System.out.println("sameActor");
		Member invokingMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("pa@pa.com").getMember();
		DeployedChainCodeEntity currentDeployment=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getCurrentDeployed();
		ResponseWrapper result = SecureManagerAPIs.addActor(invokingMember, "PGM", "sano", "zoro", "zoro",  new JSONObject(), currentDeployment);
		Assert.assertEquals(result.errorCode,ERROR_CODES.ACTOR_ALREADY_EXISTS.getErrorCode());

	}
	@Test(priority=11)
	public void createAsset(){
		System.out.println("programadmin createAsset 6");
		System.out.println("createAsset");
		Member invokingMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("pa@pa.com").getMember();
		DeployedChainCodeEntity currentDeployment=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getCurrentDeployed();
		ResponseWrapper result = SecureManagerAPIs.addAsset(invokingMember, "PGM", "asset@asset.com", 10, 1,   new JSONObject(), currentDeployment);
		Assert.assertEquals(result.errorCode,0L);

	}
	@Test(priority=11)
	public void existAsset(){
		System.out.println("programadmin createAsset 6");
		System.out.println("existAsset");
		Member invokingMember=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getUser("pa@pa.com").getMember();
		DeployedChainCodeEntity currentDeployment=com.krypc.hl.wb.serialized.PersistentManager.getInstance().getCurrentDeployed();
		ResponseWrapper result = SecureManagerAPIs.addAsset(invokingMember, "PGM", "asset@asset.com", 10, 1,   new JSONObject(), currentDeployment);
		Assert.assertEquals(result.errorCode,ERROR_CODES.ASSET_ALREADY_EXISTS.getErrorCode());

	}
	@Test
	public void participants(){
		
	}
	
	
}*/