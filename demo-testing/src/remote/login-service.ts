import {loginModel} from "../model/login-model";


let user:loginModel;

function resolvingPromis(){
    return new Promise(resolve=>{
        setTimeout(()=>{
            resolve(
                user =  {
                    id:201,
                    firstName:"Jin",
                    lastName:"Sung-Woo"
                }
            )
        },1000);
    })
}
export async function LoginBackendCall(){
    let loginUser = await resolvingPromis();
    console.log(loginUser);
    return await loginUser ;
}