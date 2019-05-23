SELECT
			`article`.`Title`
			, SUBSTRING(`article`.`Content`, 1, 30) AS Content
			, `user`.`UserName`
			, `article`.`UpdateTime`
			, `type`.`TypeName`
		FROM
			`myblog`.`article`
			INNER JOIN `myblog`.`user`
				ON (`article`.`UserID` = `user`.`UserID`)
			INNER JOIN `myblog`.`type`
				ON (`article`.`TypeID` = `type`.`TypeID`)
		WHERE (`article`.`Status` ='publish');