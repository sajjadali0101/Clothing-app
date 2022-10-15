package com.example.project.Model;

public class Menu_list {

private String ImageUrl,busId , Description, Rate;

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl =imageUrl;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }


    public Menu_list(String imageurl, String description, String rate)
    {
       ImageUrl= imageurl;
     Description=description;
        Rate=rate;

    }

    public Menu_list(){}

    public String getBusId(String key) {
        return busId;
    }
    public void setBusId(String busId) {
        this.busId = busId;
    }

}
