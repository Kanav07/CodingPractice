package TestQues;

/*1. Parse the JSON file
2. Go inside 'Body > Recommendations'
3. Print name of Restaurant
4. Go inside 'Body > Recommendations'
5. Go inside menu
6.  Loop for each menu (there can be multiple menus)
7.  Check whether type=sectionheader. If it is - go inside its 'children
8. Check whether type=item. If it is, check whether selected=1. If both are true, print the name of item, and go inside its children.
9. Check whether selected=1 (no need to pay attention to the 'type' now that we are inside children of 'item'). If selected was 1 then print the name of child, and go further deep inside the children
 Repeat the last step infinitely - until we have reached the deepest child
The output should look like this :
---------------------------------------------
Restaurant1
--> Item1
-----> Child1
----------> Child1.1
----------> Child1.2
--------------> Child1.2.1
------------------> Child1.2.1.1
------> Child2
------> Child3
----------> Child3.1
    1   2   3   4   x
Take note of length of arrows in each line above. Your output should also contain these arrows to depict the indentation of each child.*/


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class JSONParserQues {


    public static void main(String[] args) throws FileNotFoundException {

        try {
            ParseJSONPrint();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void ParseJSONPrint() throws FileNotFoundException {
        try {
            Object obj = new JSONParser().parse(new FileReader("/Users/apple/IdeaProjects/untitled1/src/TestQues/foodyo_output.json"));


            JSONObject jo = (JSONObject) obj;

            JSONObject body = (JSONObject) jo.get("body");

            JSONArray recommendations = (JSONArray) body.get("Recommendations");

            Iterator itr1 = recommendations.iterator();

            while (itr1.hasNext()) {
                JSONObject rec = (JSONObject) itr1.next();
                System.out.println(rec.get("RestaurantName"));


                JSONArray menus = (JSONArray) rec.get("menu");
                Iterator menuItr = menus.iterator();

                while (menuItr.hasNext()) {

                    JSONObject menu = (JSONObject) menuItr.next();

                    if (menu.get("type").equals("sectionheader")) {

                        JSONArray children = (JSONArray) menu.get("children");
                        Iterator childItr1 = children.iterator();
                        int level = 1;

                        while (childItr1.hasNext()) {

                            JSONObject child = (JSONObject) childItr1.next();
                            String type = (String) child.get("type");
                            long selected = (Long) child.get("selected");

                            if (type.equals("item") && selected==1) {

                                for (int i = 0; i < level; i++) System.out.print("----");
                                System.out.println("> " + child.get("name"));

                                ChildrenRecurisveParser(child,level+1);
                            }

                        }

                    }
                }

            }


        } catch (
                IOException e)

        {
            e.printStackTrace();
        } catch (
                ParseException e)

        {
            e.printStackTrace();
        }
    }


    public static void ChildrenRecurisveParser(JSONObject obj, int level){

        JSONArray objChildrenArray = (JSONArray) obj.get("children");
        Iterator childItr = objChildrenArray.iterator();

        while (childItr.hasNext()){

            JSONObject child = (JSONObject) childItr.next();

            if( (Long)child.get("selected") ==1 ){

                for (int i = 0; i < level; i++) System.out.print("----");
                System.out.println("> " + child.get("name"));
                ChildrenRecurisveParser(child,level+1);
            }
        }
    }
}









