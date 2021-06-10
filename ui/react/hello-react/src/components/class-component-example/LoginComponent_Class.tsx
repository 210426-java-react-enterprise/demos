import { Button, FormControl, Input, InputLabel, Typography } from '@material-ui/core';
import React, { SyntheticEvent } from 'react';

export class LoginComponent_Class extends React.Component<any, any> { 

    constructor(props: any) {
        super(props);
        this.state = {
            username: '',
            password: '',
            errorMessage: ''
        }
    }

    login = async () => {
        console.log(`Provided credentials: ${this.state.username}, ${this.state.password}`);
    }

    // kinda gross when you need to get data from a SyntheticEvent
    updateUsername = (e: SyntheticEvent) => {
        let data = (e.target as HTMLInputElement).value // cast to HTMLInputElement because it exposes the value field 
        console.log(data);
        this.setState({
            username: data
        });
    }

    //
    updatePassword = (e: any) => {
        let data = e.currentTarget.value;
        console.log(data);
        this.setState({
            password: data
        });
    }

    render() {
        return (
            // the <> </> are known as React fragments
            <>
                <Typography align="center" variant="h4">Log In To Your Quizzard Account!</Typography>

                <FormControl margin="normal" fullWidth>
                    <InputLabel htmlFor="username">Username</InputLabel>
                    <Input 
                        onChange={this.updateUsername}
                        id="username"
                        type="text"
                        placeholder="Enter your username"
                    />
                </FormControl>

                <FormControl margin="normal" fullWidth>
                    <InputLabel htmlFor="password">Password</InputLabel>
                    <Input 
                        onChange={this.updatePassword}
                        id="password"
                        type="password"
                        placeholder="Enter your password"
                    />
                </FormControl>
                <br/><br/>
                <Button 
                    onClick={this.login}
                    variant="contained" 
                    color="primary" 
                    size="medium">Login</Button>
            </>
        );
    }
}