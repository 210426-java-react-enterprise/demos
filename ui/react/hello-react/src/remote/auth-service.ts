import { quizzardClient } from './quizzard-client';
export async function authenticate(username: string, password: string) {
    let response = await quizzardClient.post('/auth', {username, password});
    return await response.data;
}