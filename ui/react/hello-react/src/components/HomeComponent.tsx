import { Card, CardContent, Typography } from "@material-ui/core";
import { Redirect } from "react-router";
import { User } from "../models/user";

interface IHomeProps {
    currentUser: User | undefined,
    flashcards: any[]
}

const HomeComponent = (props: IHomeProps) => {

    return (
        !props.currentUser ?
        
        <Redirect to="/login"/> 
        
        :

        <>
            <h1>Welcome, {props.currentUser.username}!</h1>
            {props.flashcards.map(flashcard => {
                return (
                <Card key={flashcard.id}>
                    <CardContent>
                        <Typography variant="h5">
                            {flashcard.question}
                        </Typography>
                        <Typography color="textSecondary">
                            {flashcard.answer}
                        </Typography>
                    </CardContent>
                </Card>
                );
            })}
        </>
    );
}

export default HomeComponent;