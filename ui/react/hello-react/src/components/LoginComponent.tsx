import { Button, FormControl, Input, InputLabel, Typography } from "@material-ui/core";
import { useState } from "react";
import { Redirect } from "react-router-dom";
import { authenticate } from "../remote/auth-service";

interface ILoginProps {
    authUser: any,
    setAuthUser: (user: any) => void
}

export function LoginComponent(props: ILoginProps) {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');

    let updateUsername = (e: any) => {
        setUsername(e.currentTarget.value);
    }

    let updatePassword = (e: any) => {
        setPassword(e.currentTarget.value);   
    }

    let login = async () => {
        let authUser = await authenticate(username, password);
        props.setAuthUser(authUser);
    }

    return (
        props.authUser ?
        <Redirect to="/home"/>
        :
        <>
            <Typography align="center" variant="h4">Log In To Your Quizzard Account!</Typography>

            <FormControl margin="normal" fullWidth>
                <InputLabel htmlFor="username">Username</InputLabel>
                <Input 
                    onChange={updateUsername}
                    id="username"
                    type="text"
                    placeholder="Enter your username"
                />
            </FormControl>

            <FormControl margin="normal" fullWidth>
                <InputLabel htmlFor="password">Password</InputLabel>
                <Input 
                    onChange={updatePassword}
                    id="password"
                    type="password"
                    placeholder="Enter your password"
                />
            </FormControl>
            <br/><br/>
            <Button 
                onClick={login}
                variant="contained" 
                color="primary" 
                size="medium">Login</Button>
        </>
    );
}
