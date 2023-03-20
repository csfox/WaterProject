using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class water_level : MonoBehaviour
{
    int i = -20;
    // Start is called before the first frame update
    void Start()
    {
        Debug.Log(transform.localScale);
    }


    // Update is called once per frame
    void Update()
    {

        transform.localScale = new Vector3(1, 1, i);
        i++;
    }
            

}
