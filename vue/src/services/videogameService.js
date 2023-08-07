import axios from "axios";

export default{

    getVideoGames(){
        return axios.get('/videogames');
    },
    
    getVideoGameById(id){
        return axios.get('/videogames/' + id);
    }
}