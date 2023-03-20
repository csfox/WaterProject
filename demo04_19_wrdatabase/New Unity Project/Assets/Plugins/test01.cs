using MySql.Data.MySqlClient;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using UnityEngine;

public class test01 : MonoBehaviour
{
    float i = -1.2f;
    float j = 0f;
    void Start()
    {
        //建立连接语句
        //charset=utf8这句要写，不然可能会报错                                 
        string constr = "server=localhost;User Id=root;password=chengruino.1;Database=wrdatabase;charset=utf8";

        //建立连接
        MySqlConnection mycon = new MySqlConnection(constr);
        //打开连接
        mycon.Open();

        //插入数据
        //MySqlCommand mycmd = new MySqlCommand("insert into studentscores(id,name,score) values (3,'lisi',100)", mycon);
        //if (mycmd.ExecuteNonQuery() > 0)
        //{
        //    print("Insert success!");
        //}

        //查询数据
        string selstr = "select * from wr_level";
        MySqlCommand myselect = new MySqlCommand(selstr, mycon);

        DataSet ds = new DataSet();

        try
        {
            MySqlDataAdapter da = new MySqlDataAdapter(selstr, mycon);
            da.Fill(ds);
            print("Query success!");
            print(ds.Tables[0].Rows[ds.Tables[0].Rows.Count-1][2]);
            i = 0-Convert.ToInt32(ds.Tables[0].Rows[ds.Tables[0].Rows.Count-1][2]);
            print(i);
        }
        catch (Exception e)
        {
            throw new Exception("SQL:" + selstr + "\n" + e.Message.ToString());
        }
        //关闭连接
        mycon.Close();
    }
    void Update()
    {
        //建立连接语句
        //charset=utf8这句要写，不然可能会报错                                 
        string constr = "server=43.143.245.176;User Id=yangchen;password=chengruino.1;Database=wrdatabase;charset=utf8";

        //建立连接
        MySqlConnection mycon = new MySqlConnection(constr);
        //打开连接
        mycon.Open();

        //插入数据
        //MySqlCommand mycmd = new MySqlCommand("insert into studentscores(id,name,score) values (3,'lisi',100)", mycon);
        //if (mycmd.ExecuteNonQuery() > 0)
        //{
        //    print("Insert success!");
        //}

        //查询数据
        string selstr = "select * from Wr_level";
        MySqlCommand myselect = new MySqlCommand(selstr, mycon);

        DataSet ds = new DataSet();

        try
        {
            MySqlDataAdapter da = new MySqlDataAdapter(selstr, mycon);
            da.Fill(ds);
            print("Query success!");
            print(ds.Tables[0].Rows[ds.Tables[0].Rows.Count - 1][2]);
            j = 0 - Convert.ToInt32(ds.Tables[0].Rows[ds.Tables[0].Rows.Count - 1][2]);
            i += (j - i) / 100;
            transform.localScale = new Vector3(1, 1,i/10);
            print(i);
        }
        catch (Exception e)
        {
            throw new Exception("SQL:" + selstr + "\n" + e.Message.ToString());
        }
        //关闭连接
        mycon.Close();
    }
}
