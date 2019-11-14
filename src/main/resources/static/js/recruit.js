$(function(){

    $('.search').click(function () {
        var url = "/zhaopin/searchtext";
        var searchText = $('.searchtext').val();

        $.ajax({
            url: url,
            type: "GET",
            data: {
                searchtext: searchText
            },
            success: function(data){
                // console.log(data)
                $('.recruitlist').remove()
                $('#data').html(data)
                $('.searchtext').val("")
            }
        })


    });

    $('.experienceitem a').click(function () {
        var url = "/zhaopin/experience";
        var experienceText = $(this).text();
        $.ajax({
            url: url,
            type: "GET",
            data:{
                experience: experienceText
            },
            success: function(data){
                // console.log(data)
                $('.recruitlist').remove()
                $('#data').html(data)
                $('.experience').text(experienceText)
            }
        })

    });

    $('.otheritem a').click(function () {
        var url = "/zhaopin/education";
        var educationText = $(this).text();
        console.log($(this).text());
        $.ajax({
            url: url,
            type: "GET",
            data:{
                education: educationText
            },
            success: function(data){
                // console.log(data)
                $('.recruitlist').remove()
                $('#data').html(data)
                $('.education').text(educationText)
            }
        })

    });

    $('.moneyitem a').click(function(){
        var url = "/zhaopin/recruit"

        console.log($(this).text());
        var index  =  $('.moneyitem a').index(this)
        console.log(index)
        var x, y
        switch(index){
            case 0:
                x = 0
                y = 1000000
                break
            case 1:
               x = 0
               y = 0
                break
            case 2:
                x = 0
                y = 2000
                break
            case 3:
                x = 2000
                y = 3000
                break
            case 4:
                x = 3000
                y = 5000
                break
            case 5:
                x = 5000
                y = 8000
                break
            case 6:
                x = 8000
                y = 10000
                break
            case 7:
                x = 10000
                y = 0
                break
        }
//        console.log(x)
//        console.log(y)

        $.ajax({
            url: url,
            type: 'GET',
            data:{
                lowSalary: x,
                highSalary: y
            },
            success: function(data){
                console.log(data)
                $('.recruitlist').remove()
                $('#data').html(data)
            }

        })

    });
});
