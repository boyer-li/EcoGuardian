package com.boyer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public String user_id;
    public String user_pwd;
    public String user_name;
    public String user_sex;
    public String user_token;
}
