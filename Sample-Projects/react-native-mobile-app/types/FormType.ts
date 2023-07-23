export type LoginType = {
  userId: string;
  keyword: string;
};

export type MpinSetUpType = {
  oldMpin: string;
  newMpin: string;
  confirmNewMpin: string;
};

export type ChangeKeywordType = {
  oldKeyword: string;
  newKeyword: string;
  confirmNewKeyword: string;
};
