package com.readwrite.json;
import org.json.JSONException;
import org.json.JSONObject;
public class ReadingNestedJsonArray {
	public static void main(String[] args) {
		String inputString="{\"photos\":[{\"url\":\"http://face.com//images//ph//0b3ecef9a00b647570027e590b72c893.jpg\",\"pid\":\"F@ddc704534bc71ad7271a1d07b95362ca_88f17d8482a3d3aac1d07b3062a3e29b\",\"width\":960,\"height\":637,\"tags\":[{\"tid\":\"TEMP_F@ddc704534bc71ad7271a1d07b95362ca_88f17d8482a3d3aac1d07b3062a3e29b_54.06_45.53_1_1\",\"recognizable\":true,\"threshold\":59,\"uids\":[{\"uid\":\"1@greene99\",\"confidence\":17}],\"gid\":null,\"label\":\"\",\"confirmed\":false,\"manual\":false,\"tagger_id\":null,\"width\":19.58,\"height\":29.51,\"center\":{\"x\":54.06,\"y\":45.53},\"eye_left\":{\"x\":49.55,\"y\":38.8},\"eye_right\":{\"x\":58.4,\"y\":38.92},\"mouth_left\":{\"x\":49.82,\"y\":52.1},\"mouth_center\":{\"x\":54.77,\"y\":53.04},\"mouth_right\":{\"x\":58.36,\"y\":52.16},\"nose\":{\"x\":54.98,\"y\":46.3},\"ear_left\":null,\"ear_right\":null,\"chin\":null,\"yaw\":-7.59,\"roll\":2.27,\"pitch\":0.01,\"attributes\":{\"age_est\":{\"value\":18,\"confidence\":30},\"age_max\":{\"value\":24,\"confidence\":30},\"age_min\":{\"value\":12,\"confidence\":30},\"face\":{\"value\":\"true\",\"confidence\":99},\"gender\":{\"value\":\"female\",\"confidence\":41},\"glasses\":{\"value\":\"false\",\"confidence\":73},\"lips\":{\"value\":\"parted\",\"confidence\":63},\"mood\":{\"value\":\"happy\",\"confidence\":61},\"smiling\":{\"value\":\"true\",\"confidence\":48}}}]}],\"status\":\"success\",\"usage\":{\"used\":1,\"remaining\":4999,\"limit\":5000,\"reset_time_text\":\"Wed, 28 Mar 2012 14:20:08 +0000\",\"reset_time\":1332944408}}";
		String uid;
		try {
			uid = new JSONObject(inputString).getJSONArray("photos").getJSONObject(0).getJSONArray("tags").getJSONObject(0).getJSONArray("uids").getJSONObject(0).getString("uid");
			System.out.println(uid);

			String tagsVal=	uid = new JSONObject(inputString).getJSONArray("photos").getJSONObject(0).getString("url");
			System.out.println(tagsVal);

			int xVal= new JSONObject(inputString).getJSONArray("photos").getJSONObject(0).getJSONArray("tags").getJSONObject(0).getJSONObject("center").getInt("x");
			System.out.println("X values of Center:"+xVal);


			int val= new JSONObject(inputString).getJSONObject("usage").getInt("reset_time");
			System.out.println("Json Object Values :-"+val);



		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
