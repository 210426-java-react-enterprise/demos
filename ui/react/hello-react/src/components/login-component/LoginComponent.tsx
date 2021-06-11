import { Alert } from '@material-ui/lab';
import { Button, FormControl, Input, InputLabel, makeStyles, Typography } from "@material-ui/core";
import { useState } from "react";
import { Redirect } from "react-router-dom";
import { User } from "../../models/user";

interface ILoginProps {
    authUser: User | undefined,
    errorMessage: string,
    loginAction: (username: string, password: string) => void
}

const useStyles = makeStyles({
    loginContainer: {
        justifyContent: "center",
        marginLeft: "25rem",
        marginTop: "10rem",
        padding: 20,
        width: "25%"
    }
});

function LoginComponent(props: ILoginProps) {

    const classes = useStyles();

    // internal component state, need not be stored in global state
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    let updateUsername = (e: any) => {
        setUsername(e.currentTarget.value);
    }

    let updatePassword = (e: any) => {
        setPassword(e.currentTarget.value);   
    }

    let login = async () => {
        console.log('login invoked!')
        props.loginAction(username, password);
    }

    return (
        
        props.authUser ?
        <Redirect to="/home"/>
        :
        <>
            {console.log('LoginComponent rerendering!')}
            <div id="login-component" className={classes.loginContainer}>
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
                    id="login-button"
                    onClick={login}
                    variant="contained" 
                    color="primary" 
                    size="medium">Login</Button>
                <br/><br/>
                {
                    props.errorMessage
                    ?
                    <Alert id="error-message" severity="error">{props.errorMessage}</Alert>
                    :
                    <></>
                }
            </div>
        </>
    );
}

export default LoginComponent;
